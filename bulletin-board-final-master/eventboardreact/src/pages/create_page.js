import React, { Component } from "react"
import CreateEventForm from "../components/CreateEventForm"
import "../styles/heading.css"

import "../styles/heading.css"

function CreatePage() {
    return (
        <div id="create_page" className="App-page">
            <br/>
            <h2>Create Post</h2>
            <br/>
            <br/>

            <div>
                <CreateEventForm />
            </div>
        </div>
    )
}

export default CreatePage