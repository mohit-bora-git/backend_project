package com.jecrc.cheggbookmanagement.model.entities;


/**
 *
 *
 *  *******-----Entity Relationship------********
 *
 *          Book N-------- 1 Author(many to one w.r.t book)
 *
 *          Book N ------- 1 Userinfo(many to one w.r.t book)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * ---------placing an order or issuing a book to user----------
 *
 * 1.validate the user---------->check is user exist or not
 * 2.validate the book---------->check if book exist and not issued
 * 3.checked student has reached the quota
 * 4.create order with pending state
 * 5.mark the book unavailable and issue it to the user
 * 6.update the order with success state
 *
 *
 *
 *
 */