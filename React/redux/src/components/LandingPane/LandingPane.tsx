import React from 'react';
import dark from './../../Assets/Clipper-Logo-Dark-Theme.png'
export function LandingPane(){
    return(
        <div className ="BlueBackground col-md-3" >
            <div>
                <img src={dark} style={{height:'150px', width:'150px'}} className = "Logo-Large"/>
                <h2>CLIPPER</h2>
            </div>
            <div>
                <p>Welcome to <strong>Clipper</strong>, the worlds fastest growing social network.</p>
                <p>Like our namesake sailing vessels of old, Clipper is revolutionizing the way that 
                    people across the world connect. We simplify and unify the social network 
                    experience by letting anyone add to <i>The Feed</i>. All you need to do is
                     <a href="d"> create an account</a> and <a href="c">login</a>!</p>
            </div>

        </div>
    )
}