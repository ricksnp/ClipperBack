import React from "react";
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import LandingPage from "./views/LandingPage/LandingPage"
import LoginPage from "./views/LoginPage";
import SignupPage from './views/SignupPage'
import ResetPassword from "./views/ResetPassword"

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/landing-page" component={LandingPage} />
        <Route path="/login" component={LoginPage} />
        <Route path="/signup" component={SignupPage} />
        <Route path="/reset-password" component={ResetPassword} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
