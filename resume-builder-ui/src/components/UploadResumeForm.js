import React, { useState } from "react";
import axios from 'axios';

const UploadResumeForm = () => {
    const [resumeDetails, setResumeDetails] = useState({
        firstName: '',
        lastName: '',
        email: '',
        currentDesignation: '',
        currentJobDescription: '',
        currentCompany: ''
    });

    const [statusMessage, setStatusMessage] = useState('');

    const handleChange = (event) => {
        const { name, value } = event.target;
        setResumeDetails((prevValues) => ({
            ...prevValues,
            [name]: value,
        }));
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await axios.post('/api/uploadResumeDetails', resumeDetails);
            console.log('The generated resume ID is: ', response.data);

            setStatusMessage('Resume details saved successfully!');
            setTimeout(() => {
                window.location.reload(); // Refresh the page after 2 seconds
            }, 2000);
        } catch (error) {
            console.error('Error uploading the resume!', error);
            setStatusMessage('Failed to save resume details!');
        }
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <table align="center">
                    <tbody>
                        <tr>
                            <td align="left"><label>First Name</label></td>
                            <td><input type="text" name="firstName" placeholder="First Name" onChange={handleChange} /></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Last Name</label></td>
                            <td><input type="text" name="lastName" placeholder="Last Name" onChange={handleChange} /></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Email</label></td>
                            <td><input type="text" name="email" placeholder="Email" onChange={handleChange} /></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Current Designation</label></td>
                            <td><input type="text" name="currentDesignation" placeholder="Current Designation" onChange={handleChange} /></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Current Job Description</label>&nbsp;&nbsp;</td>
                            <td><input type="text" name="currentJobDescription" placeholder="Current Job Description" onChange={handleChange} /></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Current Company</label></td>
                            <td><input type="text" name="currentCompany" placeholder="Current Company" onChange={handleChange} /></td>
                        </tr>
                        <tr>
                            <td colSpan="2" style={{ textAlign: "center" }}>
                                <button type="submit">Upload Resume</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
            {statusMessage && (
                <div style={{ textAlign: "center", marginTop: 20 }}>
                    <p>{statusMessage}</p>
                </div>
            )}
        </div>
    );
};

export default UploadResumeForm;