import { compose, createStore, Store } from "redux";
import { state } from "./reducers/reducer";

const a: any = window;

const composeEnhancers = (window as any).__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const enhancer = composeEnhancers();

export const store: Store<any> = createStore(state, enhancer);
