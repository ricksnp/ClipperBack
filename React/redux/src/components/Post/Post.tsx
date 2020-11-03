import React from 'react';

//import { Carousel } from './Carousel';


export function Post(prop: any) {
    return (
        <div className="Post" >
            <a href={prop.user.page}><img src={prop.profPicLink} className="Post-Profile-Pic" /></a>
            <div> {/* Needs contitional statement for Carousel */}
                {/*<Carousel prop="prom.images" />*/}
                <p>{prop.post.postText}</p>
            </div>
            <button className="like"></button>
        </div>
    )
}