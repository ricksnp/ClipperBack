import React from 'react';
import {LandingPane} from '../components/LandingPane/LandingPane'
import {Feed} from '../components/Feed/Feed'

export default function LandingPage(){
    return (
        <div className = "row">
            <LandingPane/>
            <Feed/>
            
        </div>
    )
};