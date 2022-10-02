import { useState } from 'react';
import { useDispatch } from 'react-redux';
import {addTodoItem} from "../../stores/todo"
function Form() {

    const [todo, setTodo] = useState("");
    const dispatch = useDispatch();

    function onChange(event) {
        setTodo(event.target.value);
    }

    return (
        <div className="input-group mb-3">
            <input type="text" className="form-control" placeholder="Enter new todo" value={todo} onChange={onChange}/>
            <div className="input-group-append">
                <button className="btn btn-primary" type="button" onClick={() => todo && dispatch(addTodoItem(todo))}>Add</button>
            </div>
        </div>
    );
}

export default Form;