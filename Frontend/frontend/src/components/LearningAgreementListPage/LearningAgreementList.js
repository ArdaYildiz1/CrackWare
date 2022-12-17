import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./LearningAgreementList.module.css";
import { LearningAgreementListContext } from "../../context/LearningAgreementContext/LearningAgreementListContext";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";


function LearningAgreementList() {
  const learningAgreementList = useContext(LearningAgreementListContext);
  const navigate = useNavigate();
  console.log(learningAgreementList);

  function handleInput(e) {

    //navigate(`/coordinator/applications/${uid}`)
  }
  
  function downloadForm(e) {
    console.log(e.target.value);
    const uid = e.target.value;
    console.log("a" + uid);
    var API = `http://localhost:8080/coordinator/learningAgreement/download/${uid}`;
    var requestOptions = {
      method: "POST",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      res.blob().then((blob) => {
        // Create blob link to download
        const url = window.URL.createObjectURL(
            new Blob([blob]),
        );
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute(
            'download',
            `LearningAgreement.pdf`,
        );
        link.click();
      });
    })
  }

  function approve(event) {
    console.log(event.target.value);
    const uid = event.target.value;

    var API = `http://localhost:8080/coordinator/learningAgreement/approve/${uid}`;
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
      window.location.reload();
    });
  }

  function reject(event) {
    console.log(event.target.value);
    const uid = event.target.value;
    
    var API = `http://localhost:8080/coordinator/learningAgreement/reject/${uid}`;
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {{
      console.log(res);
      window.location.reload();
    }
    });
  }

  console.log(learningAgreementList);
  return (
    <Card>
      <h3 className="heading my-3">Learning Agreement List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th className={classes.heading}>Fullname</th>
              <th className={classes.heading}>ID </th>
              <th className={classes.heading}>CGPA</th>
              <th className={classes.heading}>Download</th>
              <th className={classes.heading}>Approve</th>
              <th className={classes.heading}>Reject</th>
            </tr>
          </thead>
          <tbody>
            {learningAgreementList.map((learningAgreement) => (
              <tr key={learningAgreement.uid}>
                <td className={classes.center}>{learningAgreement.fullName}</td>
                <td className={classes.center}>{learningAgreement.id}</td>
                <td className={classes.center}>{learningAgreement.cgpa}</td>
                <td className={classes.center}>
                  <Button
                    key={`download-${learningAgreement.uid}`}
                    value={learningAgreement.uid}
                    className="button-default"
                    onClick={e => downloadForm(e, "value")}
                  >
                    Download
                  </Button>
                </td>
                <td className= {classes.center}>
                  <Button
                    key={`approve-${learningAgreement.uid}`}
                    value={learningAgreement.uid}
                    className="btn-success"
                    onClick={approve}
                  >
                    Approve
                  </Button>
                </td>
                <td className= {classes.center}>
                  <Button
                    key={`reject-${learningAgreement.uid}`}
                    value={learningAgreement.uid}
                    className ="btn-danger"
                    onClick={reject}
                  >
                    Reject
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </Card>
  );
}

export default LearningAgreementList;
