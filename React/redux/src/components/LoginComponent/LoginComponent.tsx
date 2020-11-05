
import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import light from '../../Assets/Clipper Logo Light-Theme.png'
import { login } from '../../actions/index'
import { store } from '../../Store'



export function LoginComponent() {

    useEffect(() => {
        store.dispatch(login())
    });

    return (
        <form style={{ textAlign: 'left' }}>
            <div className="logoarea pt-5 pb-5 row" >
                <a href="/login"><img src={light} height={"48px"} width={"48px"} alt="Logo" /></a><div style={{ color: "#202430", fontSize: "30px", fontWeight: "bold" }}>Clipper</div>
            </div>
            <br></br>
            <h3 style={{ color: "#202430" }}>Sign In</h3><br />

            <div className="form-group" >
                <label style={{ color: "#202430" }}>Username</label>
                <input type="text" className="form-control" placeholder="Enter username" />
            </div>

            <div className="form-group">
                <label style={{ color: "#202430" }}>Password</label>
                <input type="password" className="form-control" placeholder="Enter password" />
            </div>

            <div className="form-group">
                <div className="custom-control custom-checkbox">
                    <input type="checkbox" className="custom-control-input" id="customCheck1" />
                    <label className="custom-control-label" htmlFor="customCheck1" style={{ color: "#202430" }}>Remember me</label>
                </div>
            </div>

            <button type="submit" className="btn btn-primary btn-block" style={{ background: "#202430" }}>Submit</button>
            <p className="forgot-password text-right" style={{ color: "#202430" }} >
                <span>Forgot  <a href="/reset-password">password? </a></span>
                Need an <a href="/signup">account?</a>
            </p>
        </form>
    );
}

const mapStateToProps = (state: any) => {
    return state.users;
}

const mapDispatchToProps = {
    login
}
export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LoginComponent);