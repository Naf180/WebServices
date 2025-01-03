const express = require('express');
const bodyParser = require('body-parser');
const professeurRoutes = require('./routes/professeur');

const app = express();

// Middleware
app.use(bodyParser.json());

// Routes
app.use('/api/professeurs', professeurRoutes);

const PORT = process.env.PORT || 5000;

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});