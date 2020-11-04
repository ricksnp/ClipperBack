import React from 'react';
import light from '../../Assets/Clipper Logo Light-Theme.png'

export function ResetPassComponent() {
    return (
        <form style={{ textAlign: 'left' }}>
            <div className="logoarea pt-5 pb-5 row" >
                <a href="/login"><img src={light} height={"48px"} width={"48px"} alt="Logo" /></a><div style={{ color: "#202430", fontSize: "30px", fontWeight: "bold" }}>Clipper</div>
            </div>
            <br></br>
            <h3 style={{ color: "#202430" }}>Reset Password</h3><br />

            <div className="form-group" >
                <label style={{ color: "#202430" }}>Please enter your account email</label>
                <input type="email" className="form-control" placeholder="Email" />
            </div>
            <button type="submit" className="btn btn-primary btn-block" style={{ background: "#202430" }}>Submit</button>

        </form>
    );


}