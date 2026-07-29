import useStickyHeaders from '../hooks/useStickyHeaders';
import formT21Diagram from '../assets/images/Form_T-21.png';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';
import { useEffect, useState } from "react";
import { getAllTrackEffectiveLengths } from "../services/trackEffectiveLengthService";

export default function FormT21() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  const [trackEffectiveLengths, setTrackEffectiveLengths] = useState([]);

  useEffect(() => {
    loadTrackEffectiveLengths();
  }, []);

  const loadTrackEffectiveLengths = async () => {

    try {

      const response = await getAllTrackEffectiveLengths();
      setTrackEffectiveLengths(response);

    } catch (error) {

      console.error("Failed to load Track Effective Length", error);

    }

  };

  const records = trackEffectiveLengths;

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-21</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Track effective length in stations and depots</span>
        <span>Date: <input type="text" value={
          records[0]?.inspectionDate
            ? new Date(records[0].inspectionDate).toLocaleDateString("en-GB")
            : ""
        } readOnly className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-21.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
      <style>{'.compact-table td { padding: 6px 4px !important; font-size: 12px; line-height: 1.4; } .compact-table { font-size: 12px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 4px 4px !important; } .compact-table th { background: none !important; background-color: transparent !important; }'}</style>

      <div className="mb-3">
        <span className="me-1">Location:</span>
        <input type="text" value={records[0]?.location ?? ""} readOnly className="d-inline-block" style={{ width: '300px', border: 'none', borderBottom: '1px solid #000', background: 'transparent', outline: 'none' }} />
      </div>

      <div style={{ overflow: 'auto' }}>
        <table border="1" className="table table-bordered align-middle form-table export-table compact-table mb-0" style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr>
              <th rowSpan={2} scope="col" style={{ width: '12%' }}>Line</th>
              <th rowSpan={2} scope="col" style={{ width: '10%' }}>Chainage</th>
              <th colSpan={2} scope="col" style={{ width: '28%' }}>Distance from Fouling Mark to<br />Insulated Joint</th>
              <th colSpan={3} scope="col" style={{ width: '38%' }}>Track effective length<br />(Insulated Joint + 1.0 m - The Stop Limit Sign)</th>
              <th rowSpan={2} scope="col" style={{ width: '12%' }}>Remarks</th>
            </tr>
            <tr>
              <td><div align="center">Design value<br />(A)</div></td>
              <td><div align="center">Measured value<br />(D)</div></td>
              <td><div align="center">Design value<br />(B)</div></td>
              <td><div align="center">Measured value<br />(E)</div></td>
              <td><div align="center">Irregularity<br />(E)-(B)</div></td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>
                <div align="center" style={{ color: "blue" }}>
                  5.0 m or more
                </div>
              </td>
              <td>&nbsp;</td>
              <td>
                <div align="center" style={{ color: "blue" }}>
                  332.0 m
                </div>
              </td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>

            {records.flatMap((record, headerIndex) =>
              record.details.map((detail, detailIndex) => (
                <tr key={`${headerIndex}-${detailIndex}`}>

                  <td>{detail.lineName}</td>

                  <td>
                    {detail.chainageKm}+{detail.chainageM}
                  </td>

                  <td>{detail.distanceDesignValue}</td>

                  <td>{detail.distanceMeasuredValue}</td>

                  <td>{detail.effectiveLengthDesign}</td>

                  <td>{detail.effectiveLengthMeasured}</td>

                  <td>{detail.irregularity}</td>

                  <td>{detail.remarks}</td>

                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>

      <div className="d-flex justify-content-center mt-2">
        <img src={formT21Diagram} alt="Form T-21 reference diagram" style={{ width: '497px', height: '250px', objectFit: 'contain', background: '#fff' }} />
      </div>
    </div>
  );
}

