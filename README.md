# ResumeBuilder
## Requirements
This is a small end-to-end project to save and fetch resume details.

### Purpose
Build a simple prototype API to take resume details for a candidate and store it in the DB
The details needed to create the resume are: first name, last name, email, current job title, current job description,
current job company

### API Endpoints:
Domain: http://localhost:8080/

POST: 
- /api/uploadResumeDetails
- Input is JSON containing all the attributes (name, title, description, company)
- Output is the generated Resume ID(200 OK) or 400 for bad request

GET:
1. getResumeById 
- /api/getResumeById/<ID>
- Input is the ID
- Output is the same JSON that was POSTed

2. getResumeByName
- /api/getResumeByName/Name
- Input is the name
- Output is the same JSON that was POSTed if BOTH first and last name match; OR combined individual matches for
  first name and last name

### UI
- Build a simple form to take the details from ui and save to db
- Provide 2 options to search resume details: by ID, and by Name
- Display the fetched results


## Setup
You need to have the following installed/setup in your machine:
- JDK
- Homebrew
- Maven
- Node
- MySql
- SpringBoot project setup (refer: resume-builder/README)
- ReactJS application setup (refer: resume-builder-ui/README)

## Running the application
To be able to run the application locally, make sure that:
- SpringBoot backend application is running (refer: resume-builder/README)
- ReactJS frontend development server is running (refer: resume-builder-ui/README)
