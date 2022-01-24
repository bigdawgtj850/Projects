import React, { Component } from "react"
import { Container, Row, Col } from 'react-bootstrap'
import {useLocation} from 'react-router-dom'
import { NavLink } from 'react-router-dom'
import { Form, Button, Modal } from 'react-bootstrap'

import EditEventForm from '../components/EditEventForm'

import TextArea from "../components/inputs/TextArea";
import Input from "../components/inputs/Input";
import DropDownItem from "../components/inputs/DropDownItem";

import "../styles/form.css"


const BackEnd_URL = "http://localhost:8080/api/eventBoard"

class EditPostPage extends Component {

state = {
    submission: {
        postId: "",
        category: "",
        userName: "",
        title: "",
        dateOfEvent: "",
        addressString: "",
        zipCode: "",
        preview: "",
        eventInfo: ""
    },
        allCategories: ["Outdoor", "Gaming", "Educational", "Celebration", "Other"]
};

constructor(props) {
    super(props);

    this.handleSubmissionChange = this.handleSubmissionChange.bind(this);
    this.handleClear = this.handleClear.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
}

loadPosts() {
    console.log("Loading Posts...")
    fetch (BackEnd_URL + "/post/posts", {mode: 'cors'})
        .then(response => {
            return response.json()
        })
        .then(response => this.setState(
            {postsData: response, loading: false}
        ))
}

handleSubmissionChange(event) {
    let name = event.target.name;
    let value = event.target.value;
    
    this.setState(
        prevState => {
        return { submission: { ...prevState.submission, [name]: value } };
        },
        () =>
        console.log("changed " + name + " to: " + this.state.submission[name])
    );
    }

handleClear(event) {
    if (event) event.preventDefault();
    this.setState({
        submission: {
            postId: "",
            category: "",
            userName: "",
            name: "",
            title: "",
            dateOfEvent: "",
            addressString: "",
            zipCode: "",
            preview: "",
            eventInfo: ""
        }
    });
    console.log("Event form cleared");
}

handleSubmit = (event) => {
    if (event) event.preventDefault();
    let postId = event.target.value;
    console.log(`Submitting edit for post id ${postId}`)

    fetch(BackEnd_URL + '/post/updatePost/' + this.props.location.state.postId, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.state.submission), 
    }, {mode: 'cors'})
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        this.loadPosts();
    })
    .catch((error)=> {
        console.error('Error:', error)
    });
}


    render() {
        let {submission, allCategories} = this.state;

        return (
            <div id="edit_page" className="App-page">
            <br/>
            <h2>Edit Post</h2>
            <br/>
            <br/>
            <form>
                <div className="form">
                

                <div className="dropdownitem">
                <DropDownItem
                    title={"Category:"}
                    name={"category"}
                    value={submission.category}
                    onChange={this.handleSubmissionChange}
                    placeholder={"Select Category..."}
                    options={allCategories}
                />
                </div>

                <br/>


                <div className="entertitle">
                <Input
                    title={"Event Title:"}
                    name={"title"}
                    value={submission.title}
                    onChange={this.handleSubmissionChange}
                    type={"text"}
                    placeholder={"Enter Title..."}
                />
                </div>

                <br/>

                <div className="selectdate">
                <Input
                    title={"Event Date:"}
                    name={"dateOfEvent"}
                    value={submission.dateOfEvent}
                    onChange={this.handleSubmissionChange}
                    type={"date"}
                    />
                </div>      

                <br/>                             


                <div className="enterAddress">
                <Input
                    title={"Address:"}
                    name={"addressString"}
                    value={submission.addressString}
                    onChange={this.handleSubmissionChange}
                    type={"text"}
                    placeholder={"(ex) Arrowhead Park"}
                />
                </div>

                <br/>

                <div className="number">
                <Input
                    title={"Zip Code: "}
                    name={"zipCode"}
                    value={submission.zipCode}
                    onChange={this.handleSubmissionChange}
                    type={"number"}
                />
                </div>

                <br/>

                <div className="eventPreview">
                <Input
                    title={"Event Preview: "}
                    name={"preview"}
                    value={submission.preview}
                    onChange={this.handleSubmissionChange}
                    type={"text"}
                />
                </div>
                
                <br/>


                <div className="eventInfo">
                <TextArea
                    title={"Event Info:"}
                    name={"eventInfo"}
                    value={submission.eventInfo}
                    onChange={this.handleSubmissionChange}
                    cols={30}
                    rows={8}
                />
                </div>
                <div className="submit"><Button type="primary" onClick={this.handleSubmit} value={submission.postId}>Submit</Button></div>
                <div className="reset"><Button variant="secondary" onClick={this.handleClear}>Clear</Button></div>
                </div>
            </form>
            </div>
        )
    }
}

export default EditPostPage