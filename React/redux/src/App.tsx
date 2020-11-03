import React from "react";
import "./App.css";
import { Provider } from "react-redux";
import ClickerContainer from "./components/ClickerContainer";
import { store } from "./Store";
import {Router, Route, Switch} from 'react-router-dom';
import LandingPage from "./views/LandingPage"
function App() {
  return (
    <Provider store={store}>
      <Switch>
        <Route path="/landing-page" component={LandingPage} />
      </Switch>
    </Provider>
  );
}

export default App;
