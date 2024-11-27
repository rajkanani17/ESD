import { useState } from 'react'
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';
function Course() {
    const { facultyId, courseId } = useParams();
    const [studId, setStudId] = useState('');
    function handleRollNumberChange(event) {
        setStudId(event.target.value);
      }

      function handleSubmit(event) {
        console.log(facultyId);
        console.log(courseId);
        console.log(studId);
        event.preventDefault();
        setStudId('');
      
        // Assuming you have the faculty code and course code from the URL parameters
        if(studId!=''){
          const data = {
            courseCode: courseId,
            studId: studId,
            approved: 1
          };
        console.log("hiiiiiiiiiiiiiiiii")
          // Send a POST request to the endpoint
          fetch('http://localhost:8080/api/v1/employees/assignstudent', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify(data),
            })
              .then((response) => {
                if(response.ok){
                  //Success
                  alert('Student assigend as TA Successfully');
                }
                else if(response.status === 404){
                  // Not found Student
                  alert('Student does not exits');
                }
                else if(response.status === 500){
                  // Already Assigned
                  alert('Student is already assigned as TA');
                }
                else{
                  // General case
                  alert('An error occured while assigning the TA');
                }
              })
              // .then((response) => {
              //   if (response.ok) {
              //     // Handle success, maybe show a message or perform other actions
              //     console.log('Add TA successful');
              //   } else {
              //     // Handle errors or non-OK status codes
              //     console.error('Add TA failed with status:', response.status);
              //   }
              // })
              .catch((error) => {
                console.error('Add TA error:', error);
              });
          
        }
        
      }
      
  return (
    <>
    <div className=' text-center py-4 font-extrabold text-2xl'>
     <h1>Welcome to the course page....</h1>
     <h1>Course-Code : {courseId}</h1>
     </div>

    <form onSubmit={handleSubmit} className='text-center py-8 pt-20 grid grid-cols-1'>
      <label className=' font-bold '>
        Enter Student Roll Number to make TA :
        <input
          className="bg-slate-100 border-collapse pl-5 ml-3"
          type="text"
          value={studId}
          onChange={handleRollNumberChange}
          placeholder="Student Roll Number"
        />
      </label>
      <div className='flex justify-center '>
      <button type="submit" className='mt-6 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 border border-blue-700 rounded '>Submit</button>
      </div>
    </form>
    <div>
        <div className='flex justify-center'>
        <div className='w-96 text-center bg-blue-500 hover:bg-blue-700 text-white font-extrabold text-xl py-2 px-4 border border-blue-700 rounded '>
               <Link to={`/TaList/${facultyId}/${courseId}`}>
                  View TA's List
               </Link>
        </div>

    </div>
    </div>
    </>
  )
}

export default Course
