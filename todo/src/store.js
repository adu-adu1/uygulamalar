import { configureStore } from '@reduxjs/toolkit';
import todoReducer from './stores/todo';

export const store = configureStore({
  reducer: {
    todo: todoReducer,
  },
})