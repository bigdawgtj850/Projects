import React, { Component } from "react"
import { Container, Row, Col } from 'react-bootstrap'
import {useLocation} from 'react-router-dom'
import { NavLink } from 'react-router-dom'
import Weather from '.././components/Weather.js';

import {Button} from 'react-bootstrap'

const SinglePost = ({ post }) => {
    console.log(post)
    return (
            <div className="BigPostFormat" >
                <p className="centeredText postTitle">Title: {post.title}</p>
                <p >Date of Event: {post.dateOfEvent}</p>
                <p >Location: {post.addressString}</p>
                <p >About the Event: {post.preview}</p>
                <p className="BigPostText">Event Info: {post.eventInfo}</p>
            </div>
    )
}

const BackEnd_URL = "http://localhost:8080/api/eventBoard"

class ViewPostPage extends Component {

    state = {
        post: {
            category: "",
            user: {
                userName: ""
            },
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
        this.state = {

        };
    }

    handleDeletePost = (event) => {
        if (event) event.preventDefault();
        let postId = event.target.value;
        console.log(`Deleting post with postId ${postId}`)


        fetch(BackEnd_URL + '/post/deletePost/' + postId,
            {
                method: 'DELETE',
            }, { mode: 'cors' })
            .then(data => {
                this.loadPosts();
            })
            .catch((error) => {
                console.error('Error:', error);
            })
    }

    handleEditPost = (event) => {
        console.log("Opening Post Edit Page")
        if (event) event.preventDefault();
      
        let postId = event.target.value;
        console.log(`Editing Post id ${postId}`)
      
        
        fetch(BackEnd_URL + '/post/getPost/'+ postId, {mode: 'cors'})
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            this.setState(
              { editPostData : data , showPostModal : true}
            )
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    componentDidMount() {
        console.log("Posts page is now mounted")
        console.log(this.props.location)
    }

    render() {
        let post = this.state;
        return (
            <div id="edit_page" className="App-page">
                    <SinglePost post={this.props.location.state} key={this.props.location.postId} />
                    <Weather location={this.props.location.state.zipCode}/>
                    <div>
                </div>
            </div>

        )
    }
}

export default ViewPostPage