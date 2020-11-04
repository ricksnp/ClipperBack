import React from "react";
import { Provider } from "react-redux";
import { store } from "./Store";
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import LandingPage from "./views/LandingPage"
import LoginPage from "./views/LoginPage";
function App() {
  return (
    <div className = " GreyBackground">
    <div className = "col-8 mx-auto ">
    <BrowserRouter>
      <Switch>
        <Route path="/landing-page" component={LandingPage} />
        <Route path="/login" component={LoginPage} />
      </Switch>
    </BrowserRouter>
    </div>
    </div>
  );
}

export default App;
