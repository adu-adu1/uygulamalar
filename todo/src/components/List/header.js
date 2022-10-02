import { useEffect, useState } from "react";
import { useSelector } from "react-redux";

function Header() {
    const [count, setCount] = useState(0);
    const {todoList} = useSelector((state) => state.todo);

    useEffect(()=>{
        setCount(todoList.length);
    },[todoList])

    return (
        <div>
            <h4>Todo List</h4>
            <p className="text-right">{`There are ${count} todos.`}</p>
        </div>
    );
}

export default Header;