// controllers/professeurController.js
const Professeur = require('../models/professeur');

// Créer un nouveau professeur
exports.createProfesseur = (req, res) => {
  const { nom, prenom, email, matiereId, classeId, etudiantId } = req.body;
  Professeur.create({ nom, prenom, email, matiereId, classeId, etudiantId }, (err, id) => {
    if (err) return res.status(400).json({ message: err.message });
    res.status(201).json({ id, nom, prenom, email, matiereId, classeId, etudiantId });
  });
};

// Lire tous les professeurs
exports.getAllProfesseurs = (req, res) => {
  Professeur.findAll((err, professeurs) => {
    if (err) return res.status(500).json({ message: err.message });
    res.status(200).json(professeurs);
  });
};

// Lire un professeur par ID
exports.getProfesseurById = (req, res) => {
  Professeur.findById(req.params.id, (err, professeur) => {
    if (err) return res.status(500).json({ message: err.message });
    if (!professeur) return res.status(404).json({ message: 'Professeur not found' });
    res.status(200).json(professeur);
  });
};

// Mettre à jour un professeur par ID
exports.updateProfesseur = (req, res) => {
  const { nom, prenom, email, matiereId, classeId, etudiantId } = req.body;
  Professeur.update(req.params.id, { nom, prenom, email, matiereId, classeId, etudiantId }, (err, changes) => {
    if (err) return res.status(400).json({ message: err.message });
    if (changes === 0) return res.status(404).json({ message: 'Professeur not found' });
    res.status(200).json({ id: req.params.id, nom, prenom, email, matiereId, classeId, etudiantId });
  });
};

// Supprimer un professeur par ID
exports.deleteProfesseur = (req, res) => {
  Professeur.delete(req.params.id, (err, changes) => {
    if (err) return res.status(500).json({ message: err.message });
    if (changes === 0) return res.status(404).json({ message: 'Professeur not found' });
    res.status(200).json({ message: 'Professeur deleted' });
  });
};