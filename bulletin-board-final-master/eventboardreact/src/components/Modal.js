import React from 'react';
import { Form, Button, Modal } from 'react-bootstrap'


  class ContactModal extends React.Component {
      render() {
          let {contactData, handleSubmit, handleChange, show, handleClose} = this.props;
          return (
              <Modal show={show} onHide={handleClose} animation={false}>
                  <Modal.Dialog>
                  <Modal.Header closeButton>
                      <Modal.Title># {contactData.contactId}</Modal.Title>
                  </Modal.Header>

                  <Modal.Body>
                      <Form>
                          <Form.Group controlId="contactname">
                              <Form.Label>Name:</Form.Label>
                              <Form.Control type="text" placeholder="" name="name"
                                  value={contactData.name} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="contacttitle">
                              <Form.Label>Title:</Form.Label>
                              <Form.Control type="text" placeholder="" name="title"
                                  value={contactData.title} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="contactCompany">
                              <Form.Label>Date:</Form.Label>
                              <Form.Control type="text" placeholder="" name="date"
                                  value={contactData.date} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="contactaddress">
                              <Form.Label>Address:</Form.Label>
                              <Form.Control type="text" placeholder="" name="address"
                                  value={contactData.address} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="contactzipcode">
                              <Form.Label>ZipCode:</Form.Label>
                              <Form.Control type="text" placeholder="" name="Zipcode"
                                  value={contactData.zipcode} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="contactPreview">
                              <Form.Label>Preview:</Form.Label>
                              <Form.Control type="text" placeholder="" name="Preview"
                                  value={contactData.email} onChange={handleChange}/>
                          </Form.Group>
                          <Form.Group controlId="contactzipcode">
                              <Form.Label>EventInfo:</Form.Label>
                              <Form.Control type="text" placeholder="" name="EventInfo"
                                  value={contactData.EventInfo} onChange={handleChange}/>
                          </Form.Group>
                      </Form>
                  </Modal.Body>

                  <Modal.Footer>
                      <Button variant="secondary" onClick={handleClose}>Close</Button>
                      <Button variant="primary" onClick={handleSubmit} value={contactData.contactId}>Save changes</Button>
                  </Modal.Footer>
                  </Modal.Dialog>
              </Modal>
          )
      }
  }

  export default ContactModal