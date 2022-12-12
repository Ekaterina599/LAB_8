package component

import csstype.*
import data.Grade
import react.FC
import react.Props
import emotion.react.css
import react.dom.html.ReactHTML.option
import react.dom.html.ReactHTML.select
import react.redux.useSelector
import react.useContext
import redux.AppState

external interface GradeProps : Props {
    var grade: Grade
    var setGrade: (Grade) -> Unit
}


val CGrade =FC<GradeProps>("Grade") { props ->
    val color = useSelector {state: AppState -> state.color}
    val list = listOf(1,2,3,4,5)
    select {
        css{ backgroundColor = Color(color[props.grade-1])}
        id = "gradeList ${props.grade}"
        onChange = { props.setGrade(it.target.value.toInt()) }
        value = props.grade.toString()
        list.mapIndexed { index, it ->
            option {
                css{ backgroundColor = Color(color[index])}
                +it.toString()
                id = "optionGrade ${it.toString()}"
            }
        }
    }
}