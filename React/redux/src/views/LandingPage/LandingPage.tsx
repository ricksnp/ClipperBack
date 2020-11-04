import React from 'react';

import {LandingPane} from '../../components/LandingPane/LandingPane'
import {Feed} from '../../components/Feed/Feed'
import './LandingPage.css'

export default function LandingPage() {
    return (
        <div className = "row">
            <LandingPane/>
            <Feed/>
        </div>
    )
};