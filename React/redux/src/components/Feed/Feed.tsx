import React from 'react';

import {Post} from '../Post/Post'

export function landingPane(props:any){
    return(
        <div className = "col-md-8" >
            <div className = "BlueBackground">
                <img src="#" className = "logo-small centered mx-auto"></img>
            </div>
            <div className = "GreyBackground">
                {props.map((prop:any) => (
                    <Post key={prop.id} prop={prop}/>
                ))}
            </div>
            

        </div>
    )
}