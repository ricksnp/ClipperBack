import React from 'react';
import { LandingPane } from '../components/LandingPane/LandingPane'
import { Feed } from '../components/Feed/Feed'

export default function LandingPage() {
    return (
        <div>
            <div className="landing">
                <LandingPane />
            </div>
            <div className="feed">
                <Feed />
            </div>
        </div>
    )
};