import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    todoList: [
        {
            "id": 0,
            "todo": "Buy milk",
            "isCompleted": false
        },
        {
            "id": 1,
            "todo": "Some eggs",
            "isCompleted": false
        },
        {
            "id": 2,
            "todo": "Go to work",
            "isCompleted": true
        }
    ]
}

export const todoSlice = createSlice({
    name: 'todoList',
    initialState,
    reducers: {
        addTodoItem: (state, action) => {

            const todo = action.payload;

            const isExists = state.todoList.filter((item, index) => {
                return item.todo === todo;
            });

            if (isExists.length === 0) {
                let maxId = 0;

                state.todoList.map((item, index) => {
                    return item.id > maxId ? maxId = item.id : maxId
                });
                
                const todoItem = {
                    id: (maxId + 1),
                    todo,
                    isCompleted: false
                };

                state.todoList = [...state.todoList, (todoItem.todo !== "" && todoItem)];
            }
        },
        changeCompletedStatus: (state, action) => {

            const index = action.payload;

            const newTodoList = state.todoList.map((item, i) => {
                if (!item.isCompleted && i === index)
                    item.isCompleted = true;
                else if (item.isCompleted && i === index)
                    item.isCompleted = false;
                return item;
            });

            state.todoList = newTodoList;

        },
        deleteTodoItem: (state, action) => {
            const index = action.payload;

            state.todoList = state.todoList.filter((item, i) => {
                return (
                    index !== i
                )
            });
        },
    },
})

export const { addTodoItem, changeCompletedStatus, deleteTodoItem } = todoSlice.actions

export default todoSlice.reducer