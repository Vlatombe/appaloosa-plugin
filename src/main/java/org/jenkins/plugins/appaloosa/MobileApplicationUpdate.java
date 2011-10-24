package org.jenkins.plugins.appaloosa;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileApplicationUpdate {
	private static ObjectMapper jsonMapper = new ObjectMapper();

	public Integer id;
	public Integer status;
	@JsonProperty(value = "application_id")
	public String applicationId;

	public static MobileApplicationUpdate createFrom(String json)
			throws AppaloosaDeployException {
		try {
			return jsonMapper.readValue(json, MobileApplicationUpdate.class);
		} catch (Exception e) {
			throw new AppaloosaDeployException(
					"impossible to parse mobileApplicationUpdate string: "
							+ json, e);
		}
	}
}
