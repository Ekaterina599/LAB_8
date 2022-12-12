package component

import AddColor
import csstype.*
import emotion.react.css
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.redux.useDispatch
import react.redux.useSelector
import redux.AppState
import redux.RAction


val CColor = FC<Props> {
    val listColor = useSelector{state: AppState -> state.color }
    val dispatch = useDispatch<RAction, Unit>()
    listOf(1,2,3,4,5).mapIndexed { indexGrade, grade ->
        label { + grade.toString() }
        input {
            type = InputType.color
            value = Color(listColor[indexGrade])
            onChange = { dispatch(AddColor(indexGrade, it.target.value)) }
        }
    }
}



