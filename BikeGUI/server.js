const express = require("express");
const app = express();

app.get("/barcode", (req, res) => {
  const barcode = req.query.b;
  res.send({
    "barcode": barcode
  })
});

app.listen(3000, () => {
  console.log(`Server has started at port 3000`);
});