import { useDispatch, useSelector } from "react-redux";
import {changeCompletedStatus, deleteTodoItem} from "../../stores/todo";

function ListItem() {
    const {todoList} = useSelector((state) => state.todo)
    const dispatch = useDispatch();

    return (
        todoList.map((item, index) => {
            const {todo, isCompleted} = item;
            return (
                <div className="row p-2 border" key={index}>
                    <div className="col">
                        <span className="mt-3" style={ { textDecorationLine: isCompleted && 'line-through' }}>{todo}</span>
                        <div className="float-right">
                            <button className={isCompleted ? 'btn btn-warning mx-2' : 'btn btn-success mx-2'} type="button" onClick={() => dispatch(changeCompletedStatus(index))}> {isCompleted ? 'Not Complete' : 'Complete'}</button>
                            <button className="btn btn-danger" type="button" onClick={() => dispatch(deleteTodoItem(index))}>Delete</button>
                        </div>
                    </div>
                </div>
            )
        })

    );
}

export default ListItem;