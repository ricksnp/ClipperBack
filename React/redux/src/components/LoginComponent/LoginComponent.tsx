
import React, { useEffect, useState } from 'react';
import { connect } from 'react-redux';
import light from '../../Assets/Clipper Logo Light-Theme.png'
import { login } from '../../_actions/index'
import { store } from '../../Store'
import { Form } from 'reactstrap';
import { FormControl } from 'react-bootstrap';
import { getPosts } from '../../_util/APIUtility';
import { axiosInstance } from '../../_util/axiosConfig';
import * as t from '../../_action.types/actionTypes'


function LoginComponent(props: any) {

    const [validated, setValidated] = useState(false);

    const handleSubmit = (event: any) => {
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        }

        setValidated(true);
    };

    useEffect(() => {
        console.log("in the use effect")
        //props.loginUsers();
    });

    return (
        <Form validated={validated ? 1 : 0} onSubmit={handleSubmit} style={{ textAlign: 'left' }}>
            <div className="logoarea pt-5 pb-5 row" >
                <a href="/login"><img src={light} height={"48px"} width={"48px"} alt="Logo" /></a><div style={{ color: "#202430", fontSize: "30px", fontWeight: "bold" }}>Clipper</div>
            </div>
            <br></br>
            <h3 style={{ color: "#202430" }}>Sign In</h3><br />

            <div className="form-group" >
                <label style={{ color: "#202430" }}>Username</label>
                <input type="text" required className="form-control" placeholder="Enter username" />
            </div>

            <div className="form-group">
                <label style={{ color: "#202430" }}>Password</label>
                <FormControl type="password" required className="form-control" placeholder="Enter password" />
            </div>

            <button type="submit" className="btn btn-primary btn-block" style={{ background: "#202430" }}>Submit</button>
            <p className="forgot-password text-right" style={{ color: "#202430" }} >
                <span>Forgot  <a href="/reset-password">password? </a></span>
                Need an <a href="/signup">account?</a>
            </p>
        </Form>
    );
}

const mapStateToProps = (state: any) => {
    return { users: state.users };
}

const mapDispatchToProps = {
    login
}
export default connect(mapStateToProps, mapDispatchToProps)(LoginComponent);