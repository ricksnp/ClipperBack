import React from "react";
import { Provider } from "react-redux";
//import { store } from "./Store";
import { Router, Route, Switch, BrowserRouter } from 'react-router-dom';
import LandingPage from "./views/LandingPage"
function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/landing-page" component={LandingPage} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
