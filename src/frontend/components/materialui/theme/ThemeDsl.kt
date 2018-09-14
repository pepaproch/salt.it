package frontend.components.materialui.theme

import kotlinx.css.Rule
import kotlinx.css.RuleContainer
import kotlinx.css.RuleSet
import kotlinx.css.TagSelector
import react.RBuilder
import react.RHandler


interface OverideOptionWrapper {
    val overideRule : MutableList<>
}

data class OverideComponentOptions (val selectorName : String , val ruleSet: RuleSet )
data class OverideOptions(val component: String )



class OverideBuilder {
    operator fun String.invoke(block: RuleSet) = rule(this, block)
 operator fun ComponentSelector.invoke(block: OverideBuilder.() -> Unit) = componentName(block)


    fun build(): OverideOptions {
     return   OverideOptions("")
    }
}


class MuiThemeOptions private constructor(typography: TypographyThemeOptions?) : ThemeOptions {

    override var typography: TypographyThemeOptions? = typography


    private constructor(builder: Builder) : this(builder.typography)

    class Builder private constructor() {

        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        var typography: TypographyThemeOptions? = null
        var overides : OverideOptions ? = null
        fun typography(block: MuiTypographyThemeOptions.Builder.() -> Unit) {
            typography = MuiTypographyThemeOptions.Builder().apply(block).build()
        }

        fun overides(block : OverideBuilder.()-> Unit) {
           overides =  OverideBuilder().apply(block).build()
        }

        fun build() = MuiThemeOptions(typography)

    }

    companion object {
        fun create(init: Builder.() -> Unit) = Builder(init).build()
    }

}


class MuiTypographyThemeOptions(override var fontSize: Int?) : TypographyThemeOptions {

    class Builder {
        var fontSize: Int? = null

        fun build() = MuiTypographyThemeOptions(fontSize)
    }


}

fun RBuilder.MuiThemeProvider(theme: Theme, handler: RHandler<ThemeProps>) = child(MuiThemeProvider::class) {
    attrs.theme = theme
    handler()
}

class CSSBuilder(val indent: String = "", val allowClasses: Boolean = true) : StyledElement(), RuleContainer {
    var styleName: String? = null

    var classes = mutableListOf<String>()

    override fun toString() = buildString {
        declarations.forEach {
            append("${it.key.hyphenize()}: ${it.value};\n")
        }

        buildRules(indent)
    }

    override val rules = mutableListOf<Rule>()

    operator fun String.invoke(block: RuleSet) = rule(this, block)

    operator fun TagSelector.invoke(block: RuleSet) = tagName(block)

    // https://developer.mozilla.org/en/docs/Web/CSS/Pseudo-classes
    // The more exotic ones were omitted
    fun active(block: RuleSet) = "&:active"(block)

    fun checked(block: RuleSet) = "&:checked"(block)
    fun disabled(block: RuleSet) = "&:disabled"(block)
    fun empty(block: RuleSet) = "&:empty"(block)
    fun enabled(block: RuleSet) = "&:enabled"(block)
    fun firstChild(block: RuleSet) = "&:first-child"(block)
    fun firstOfType(block: RuleSet) = "&:first-of-type"(block)
    fun focus(block: RuleSet) = "&:focus"(block)
    fun hover(block: RuleSet) = "&:hover"(block)
    fun lastChild(block: RuleSet) = "&:last-child"(block)
    fun lastOfType(block: RuleSet) = "&:last-of-type"(block)
    fun link(block: RuleSet) = "&:link"(block)
    fun onlyChild(block: RuleSet) = "&:only-child"(block)
    fun onlyOfType(block: RuleSet) = "&:only-of-type"(block)
    fun visited(block: RuleSet) = "&:visited"(block)

    // Children & descendants
    fun children(selector: String? = null, block: RuleSet) = "& > ${selector?.let { it } ?: "*"}"(block)

    fun descendants(selector: String? = null, block: RuleSet) = "& ${selector?.let { it } ?: "*"}"(block)

    // TODO refactor, uses a dev-mode property!
    fun ancestorHover(styleName: String, block: RuleSet) = "[data-style*=\"$styleName\"]:hover &"(block)

    // https://developer.mozilla.org/en/docs/Web/CSS/Pseudo-elements
    fun after(block: RuleSet) = "&::after" {
        content = "".quoted
        block()
    }

    fun before(block: RuleSet) = "&::before" {
        content = "".quoted
        block()
    }

    fun placeholder(block: RuleSet) {
        "&::placeholder"(block)
        "&::-webkit-input-placeholder"(block) // Chrome, Opera, Safari
        "&::-moz-placeholder"(block) // Firefox 19+
        "&::-ms-input-placeholder"(block) // IE 10+
        "&:-moz-placeholder"(block) // Firefox 18-
    }

    // Combinators
    fun child(selector: String, block: RuleSet) = "> $selector"(block)

    fun sibling(selector: String, block: RuleSet) = "~ $selector"(block)

    fun adjacentSibling(selector: String, block: RuleSet) = "+ $selector"(block)

    operator fun compareTo(rule: Rule): Int {
        // remove current rule
        rules.removeAt(rules.lastIndex)
        child(rule.selector, rule.block)
        return 0
    }

    operator fun Rule.not() {
        rules.removeAt(rules.lastIndex)
        selector.replace(Regex("^(&?)(.*)$"), "$1:not($2)")(block)
    }

    operator fun Rule.unaryPlus() {
        rules.removeAt(rules.lastIndex)
        "&.$selector"(block)
    }

    fun specific(specificity: Int = 2, block: RuleSet) = "&".repeat(specificity)(block)

    fun media(query: String, block: RuleSet) = "@media $query"(block)

    operator fun RuleSet.unaryPlus() = this()

    operator fun String.unaryPlus() {
        if (!allowClasses) {
            throw RuntimeException("class names are not allowed for this builder")
        }
        classes.add(this)
    }

    operator fun Array<String>.unaryPlus() {
        if (!allowClasses) {
            throw RuntimeException("class names are not allowed for this builder")
        }
        this.forEach { classes.add(it) }
    }

    operator fun Iterable<String>.unaryPlus() {
        if (!allowClasses) {
            throw RuntimeException("class names are not allowed for this builder")
        }
        this.forEach { classes.add(it) }
    }
}