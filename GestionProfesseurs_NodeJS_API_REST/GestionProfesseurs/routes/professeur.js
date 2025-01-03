// routes/professeur.js
const express = require('express');
const router = express.Router();
const professeurController = require('../controllers/professeurController');

router.post('/', professeurController.createProfesseur);
router.get('/', professeurController.getAllProfesseurs);
router.get('/:id', professeurController.getProfesseurById);
router.put('/:id', professeurController.updateProfesseur);
router.delete('/:id', professeurController.deleteProfesseur);

module.exports = router;