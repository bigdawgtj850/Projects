import React, { Component } from 'react';
import { Container, Row, Col } from 'react-bootstrap'
import { Table } from 'react-bootstrap'
import DisplayModal from './DisplayModal'
import { NavLink } from 'react-router-dom'
import TextArea from "./inputs/TextArea";
import Input from "./inputs/Input";
import DropDownItem from "./inputs/DropDownItem";
//import Button from "./inputs/Button";

import { Button } from 'react-bootstrap'

const BACKEND_URL = "http://localhost:8080/api/eventBoard/"

const SinglePost = ({ post, toggleDelete, toggleEdit }) => {
    console.log(post)
    return (
        <Row>
            <div>
                <p className="centeredText postTitle">Title: {post.title}</p>
                <p className="postText">Date of Event: {post.dateOfEvent}</p>
                <p className="postText">Location: {post.addressString}</p>
                <p className="postText">About the Event: {post.preview}</p>
                <p><Button variant="secondary" onClick={toggleDelete} value={post.postId}>Delete</Button></p>

            </div>
        </Row>
    )
}

class DisplaySmallPosts extends React.Component {

    static defaultProps = {
        posts: [
            {
                "postId": 1,
                "title": "Outdoor Event",
                "dateOfEvent": "2/12/2021",
                "addressString": "123 Fake Street",
                "preview": "Outdoor Picnic",
                "user": {
                    "userName": "Natasha Kinder"
                }
            },
            {
                "postId": 2,
                "title": "Other Event",
                "dateOfEvent": "3/15/2021",
                "addressString": "My House",
                "preview": "Horse Riding Lessons",
                "user": {
                    "userName": "John Smith"
                }
            },
            {
                "postId": 3,
                "title": "Educational Event",
                "dateOfEvent": "2/28/2021",
                "addressString": "Tony's Restaurant",
                "preview": "Cooking Class",
                "user": {
                    "userName": "Bobert West"
                }
            },
            {
                "postId": 4,
                "title": "Birthday Party",
                "dateOfEvent": "2/13/2021",
                "addressString": "290 Ogden Ave",
                "preview": "Celebrate!",
                "user": {
                    "userName": "Natasha Kinder"
                }
            }
        ]
    }

    state = {
        renderPosts: false,
        post: {
            postId: "",
            title: "",
            dateOfEvent: "",
            addressString: "",
            preview: "",
            user: {
                userName: ""
            }
        },
        allCategories: ["Outdoor", "Gaming", "Educational", "Celebration", "Other"]
    };

    constructor(props) {
        super(props);
        this.state = {

        };
    }

    render() {
        let columns = []
        console.log("Rendering posts...")
        console.log(this.props.posts)

        {
            this.props.posts.forEach((post, p) => {
                columns.push(
                    <div className="postFormat" key={p}>
                        <NavLink to={{
                            pathname: '/view',
                            state: post 
                        }}>View Post</NavLink>
                        <br />
                        <NavLink to={{
                            pathname: '/edit',
                            state: post 
                        }}>Edit Post</NavLink>
                        <SinglePost post={post} key={p} toggleDelete={this.props.handleDelete} />
                    </div>
                )
                if ((p + 1) % 3 === 0) { columns.push(<div className="w-100"></div>) }
            })
        }
        return (
            <div className="row">
                {columns}
            </div>
        )
    }

}

export default DisplaySmallPosts;