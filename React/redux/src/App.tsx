import React from "react";
import "./App.css";
import { Provider } from "react-redux";
import ClickerContainer from "./components/ClickerContainer";
import { store } from "./Store";
function App() {
  return (
    <Provider store={store}>
      <ClickerContainer />
    </Provider>
  );
}

export default App;
