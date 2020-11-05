import { applyMiddleware, compose, createStore, Store } from "redux";
import { UserReducer } from "./reducers/UserReducer";
import thunk from "redux-thunk"
const a: any = window;

const composeEnhancers = (window as any).__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;


export const store = createStore(UserReducer, composeEnhancers(applyMiddleware(thunk)))


