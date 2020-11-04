import React from 'react';
import dark from './../../Assets/Clipper-Logo-Dark-Theme.png'
//import {Carousel} from './Carousel'

export function Post(prop:any){
    return(
        <div className = "Post row">
            <a href='#' className='col-2'><img src={dark} className="Post-Profile-Pic" style={{width:'90px',height:"90px"}}/></a>
            <div className = "col-9 whiteText"> {/* Needs contitional statement for Carousel */}
                {/*<Carousel prop="prom.images"/>*/}
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
            <div style={{display:"flex", alignItems: "center"}}>
            <button style={{width:'40px', height:'40px', alignItems:'center', justifyContent:'center'}} className="like "></button>          
            </div>
        </div>
    )
}