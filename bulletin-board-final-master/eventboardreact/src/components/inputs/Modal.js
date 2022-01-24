import React from 'react';
import { Form, Button, Modal } from 'react-bootstrap'


  class Modal extends React.Component {
      render() {
          let {postsData, handleSubmit, handleChange, show, handleClose} = this.props;
          return (
              <Modal show={show} onHide={handleClose} animation={false}>
                  <Modal.Dialog>
                  <Modal.Header closeButton>
                      <Modal.Title># {postsData.postId}</Modal.Title>
                  </Modal.Header>

                  <Modal.Body>
                      <Form>
                          <Form.Group controlId="Name">
                              <Form.Label>Name:</Form.Label>
                              <Form.Control type="text" placeholder="" name="name"
                                  value={postsData.name} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="Title">
                              <Form.Label>Title:</Form.Label>
                              <Form.Control type="text" placeholder="" name="title"
                                  value={postsData.title} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="Date">
                              <Form.Label>Date:</Form.Label>
                              <Form.Control type="text" placeholder="" name="date"
                                  value={postsData.date} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="Address">
                              <Form.Label>Address:</Form.Label>
                              <Form.Control type="text" placeholder="" name="address"
                                  value={postsData.address} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="zipCode">
                              <Form.Label>ZipCode:</Form.Label>
                              <Form.Control type="text" placeholder="" name="Zipcode"
                                  value={postsData.zipcode} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="Preview">
                              <Form.Label>Preview:</Form.Label>
                              <Form.Control type="text" placeholder="" name="Preview"
                                  value={postsData.email} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="EventInfo">
                              <Form.Label>EventInfo:</Form.Label>
                              <Form.Control type="text" placeholder="" name="EventInfo"
                                  value={postsData.EventInfo} onChange={handleChange}/>
                          </Form.Group>
                      </Form>
                  </Modal.Body>

                  <Modal.Footer>
                      <Button variant="secondary" onClick={handleClose}>Close</Button>
                      <Button variant="primary" onClick={handleSubmit} value={postsData.postId}>Save changes</Button>
                  </Modal.Footer>
                  </Modal.Dialog>
              </Modal>
          )
      }
  }

  export default Modal