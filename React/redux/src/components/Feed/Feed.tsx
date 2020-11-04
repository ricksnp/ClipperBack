import React from 'react';

import dark_theme_logo from './../../Assets/Clipper-Logo-Dark-Theme.png'
import {Post} from '../Post/Post'

export function Feed(props:any){
    return(
        <div className = "col-md-9" style={{padding:'0px'}}>
            <div className = "BlueBackground">
                <img src={dark_theme_logo} className = "logo-small mx-auto" style={{width: "50px", height: "50px", padding:'10px', display:"block"}}></img>
            </div>
            <div className = "GreyBackground">
                {/*{props.map((prop:any) => (
                    <Post key={prop.id} prop={prop}/>
                ))}*/}
                <Post/>
                <Post/>
                <Post/>
                <Post/>
                <Post/>
                <Post/>
                <Post/>
                <Post/>

            </div>
        </div>
    )
}