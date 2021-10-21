package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RSSItem {
	private String title;
	private String link;
	private String description;
	private LocalDate pubDate;
}
