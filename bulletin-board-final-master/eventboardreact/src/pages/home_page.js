import React, { Component } from "react"
import {Container, Row, Col} from 'react-bootstrap'
import EventDisplayForm from "../components/CreateEventForm"
import DisplaySmallPosts from "../components/DisplaySmallPosts"
import DisplayPostForm from "../components/DisplayPostForm"

import '../styles/posts_page.css';

const BackEnd_URL = "http://localhost:8080/api/eventBoard/"

class HomePage extends Component {

    state = {
        loading: false,
        postsData: [
            {

            }],
    }

    loadPosts() {
        this.setState({loading: true})
        console.log("Loading Posts...")
        fetch (BackEnd_URL + "/post/posts", {mode: 'cors'})
            .then(response => {
                return response.json()
            })
            .then(response => this.setState(
                {postsData: response, loading: false}
            ))
    }

    componentDidMount() {
        console.log("Posts page is now mounted")
        this.loadPosts();
    }

    render() {
        return (
            <div id="home_page" className="App-page">
                <header className="App-header">
                </header>
    
                <Container fluid>
                        <Row>
                            <Col>
                            <DisplaySmallPosts className="postFormat" posts={this.state.postsData} />  
                            </Col>
                        </Row>
                    </Container>
            </div>
        )
    }
    
}

export default HomePage