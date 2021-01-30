package com.ubs.assesment.nitin.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * The Class RolesRightsConfig will cache rights in map
 */
@Component
public class RolesRightsConfig {

	/** The role rights map. */
	private final Map<Integer, List<String>> roleRightsMap = new HashMap<>();

	/**
	 * Load rights.
	 */
	@PostConstruct
	public void loadRights() {
		List<String> adminRights = new ArrayList<>();
		adminRights.add("VIEW");
		adminRights.add("ADM_VIEW");

		List<String> userRights = new ArrayList<>();
		userRights.add("VIEW");
		roleRightsMap.put(1, adminRights);
		roleRightsMap.put(2, userRights);
	}

	/**
	 * Gets the airline role right map.
	 *
	 * @return the airline role right map
	 */
	public Map<Integer, List<String>> getAirlineRoleRightMap() {
		return Collections.unmodifiableMap(roleRightsMap);
	}

}

