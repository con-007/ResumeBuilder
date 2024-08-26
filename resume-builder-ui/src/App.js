import './App.css';

import UploadResumeForm from './components/UploadResumeForm';
import FetchResume from './components/FetchResume';

function App() {
  return (
    <div className="App">
      <h1>Resume Builder Demo</h1>
      <br/>
      <h2>Save Resume Details</h2>
      <UploadResumeForm/>
      <br/>
      <hr/>
      <h2>Fetch Resume Details</h2>
      <FetchResume/>
    </div>
  );
}

export default App;
