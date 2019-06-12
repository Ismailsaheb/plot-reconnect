package com.plot.socialnetwork.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.plot.socialnetwork.domain.Message;
import com.plot.socialnetwork.domain.Person;
import com.plot.socialnetwork.repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

	private final MessageRepository messageRepository;

	public List<Message> getDialog(Person person, Person interlocutor) {
		return messageRepository.findByRecipientOrSenderOrderByPostedDesc(person, interlocutor);
	}

	public List<Message> getLastMessages(Person person) {
		return messageRepository.findLastMessagesByPerson(person);
	}

	public Message send(Message message) {
		return messageRepository.save(message);
	}

}
