import React, { Component } from "react"
import { Container, Row, Col } from 'react-bootstrap'
import DisplaySmallPosts from "../components/DisplaySmallPosts"
import DisplayPostForm from "../components/DisplayPostForm"
import '../styles/posts_page.css';
import { Switch } from "react-router-dom/cjs/react-router-dom.min";
import { Route } from "react-router-dom"
import ViewPostPage from '.././pages/view_page'
import { NavLink } from 'react-router-dom'


const BackEnd_URL = "http://localhost:8080/api/eventBoard"

class PostsPage extends React.Component {

    state = {
        loading: false,
        postsData: [
            {

            }],
    }

    loadPosts() {
        this.setState({ loading: true })
        console.log("Loading Posts...")
        fetch(BackEnd_URL + "/post/posts", { mode: 'cors' })
            .then(response => {
                return response.json()
            })
            .then(response => this.setState(
                { postsData: response, loading: false }
            ))
    }

    componentDidMount() {
        console.log("Posts page is now mounted")
        this.loadPosts();
    }

    toggleHidden() {
        this.setState({
            isHidden: !this.state.isHidden
        })
    }

    fetchPost(id) {
        this.toggleHidden.bind(this);
        <DisplayPostForm className="postFormat" />
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

    handleEditModalOpen = (event) => {
        console.log("Opening Post Edit Modal")
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

    render() {
        return (
            <div id="posts_page" className="App-page">
                <Container fluid>
                    <Row>
                        <Col>
                            <DisplaySmallPosts className="postFormat" posts={this.state.postsData}
                                               handleDelete={this.handleDeletePost}
                                               handleEdit={this.handleEditModalOpen} />
                        </Col>
                    </Row>
                </Container>
            </div>
        )
    }

}

export default PostsPage

// goes on line 38 (with DisplaySmallPosts)
// posts={this.state.postsData} />