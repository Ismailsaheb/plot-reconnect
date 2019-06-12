
package com.plot.commute.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.plot.commute.entity.LandDetail;
import com.plot.commute.entity.SarveyDetail;
import com.plot.commute.entity.Venture;
import com.plot.commute.entity.VillageLkp;
import com.plot.commute.repository.JpaRepository.BaseLkpRepository;
import com.plot.commute.repository.JpaRepository.LandRepository;
import com.plot.commute.repository.JpaRepository.SarveyRepository;
import com.plot.commute.repository.JpaRepository.VentureRepository;

//@Service
//@Transactional
public class DBinitLoadService {
	@Autowired
	private SarveyRepository sarveyRepository;

	@Autowired
	private VentureRepository ventureRepository;

	@Autowired
	private BaseLkpRepository baseLkpRepository;

	@Autowired
	private LandRepository landRepository;

	private final static String[] firstName;

	private final static String[] lastName;

	static {
		firstName = new String[10];
		firstName[0] = "Malla";
		firstName[1] = "Guptha";
		firstName[2] = "Behati";
		firstName[3] = "Ananad";
		firstName[4] = "Aphle";
		firstName[5] = "Sureka";
		firstName[6] = "Reddy";
		firstName[7] = "Nayadu";
		firstName[8] = "Chudari";
		firstName[9] = "Chinna";

		lastName = new String[10];
		lastName[0] = "Raju";
		lastName[1] = "Rahul";
		lastName[2] = "Chetan";
		lastName[3] = "Rama";
		lastName[4] = "Reventh";
		lastName[5] = "Charan";
		lastName[6] = "Tarak";
		lastName[7] = "Krishan";
		lastName[8] = "Shiva";
		lastName[9] = "Arjun";
	}

	Long i = 1L;
	Long j = 1L;

	@PostConstruct
	public void init() {

		VillageLkp village = new VillageLkp(1L, "Chitkul");
		this.baseLkpRepository.save(village);
		Venture vnPhase1 = new Venture(1L, "SAI SANTOSHI- PHASE-I", null, village, null, null);
		Venture vnPhase2 = new Venture(2L, "SAI SANTOSHI- PHASE-II", null, village, null, null);
		Venture vnPhase3 = new Venture(3L, "SAI SANTOSHI- PHASE-III", null, village, null, null);
		this.ventureRepository.save(vnPhase1);
		this.ventureRepository.save(vnPhase2);
		this.ventureRepository.save(vnPhase3);

		List<SarveyDetail> sarvaylist = new ArrayList<>();
		Stream.of("438", "442", "447", "449", "450", "451", "452", "453", "454").forEach(arg -> {
			Venture venture = new Venture();
			venture.setId(1L);
			VillageLkp villageLkp = new VillageLkp();
			villageLkp.setId(1L);
			SarveyDetail sarveyDetail = new SarveyDetail(this.i++, arg, venture, villageLkp, null);
			this.sarveyRepository.save(sarveyDetail);
			sarvaylist.add(sarveyDetail);
		});
		Stream.of("459/A", "459/AA", "463", "464", "465", "466", "467", "468", "469", "470", "471").forEach(arg -> {
			Venture venture = new Venture();
			venture.setId(2L);
			VillageLkp villageLkp = new VillageLkp();
			villageLkp.setId(1L);
			SarveyDetail sarveyDetail = new SarveyDetail(this.i++, arg, venture, villageLkp, null);
			this.sarveyRepository.save(sarveyDetail);
			sarvaylist.add(sarveyDetail);
		});
		Stream.of("473", "475", "476", "477", "478", "479").forEach(arg -> {
			Venture venture = new Venture();
			venture.setId(3L);
			VillageLkp villageLkp = new VillageLkp();
			villageLkp.setId(1L);
			SarveyDetail sarveyDetail = new SarveyDetail(this.i++, arg, venture, villageLkp, null);
			this.sarveyRepository.save(sarveyDetail);
			sarvaylist.add(sarveyDetail);
		});

		sarvaylist.forEach(sarvay -> {
			LandDetail landDetail = new LandDetail(this.j++, sarvay.getVenture(), sarvay, this.getRandomOwnerName(),
					this.getRandomDocumentId(), this.getRandomPhoneNumber(), "XYZ@gmail.com");
			LandDetail landDetail1 = new LandDetail(this.j++, sarvay.getVenture(), sarvay, this.getRandomOwnerName(),
					this.getRandomDocumentId(), this.getRandomPhoneNumber(), "TestMail@gmail.com");
			this.landRepository.save(landDetail);
			this.landRepository.save(landDetail1);
		});

	}

	public String getRandomOwnerName() {
		return lastName[(int) (Math.random() * 10)] + " " + firstName[(int) (Math.random() * 10)];
	}

	public String getRandomDocumentId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public String getRandomPhoneNumber() {
		return "+91-9123456789";
	}
}