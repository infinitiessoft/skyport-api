package com.infinities.skyport.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XMLUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(XMLUtil.class);


	private XMLUtil() {

	}

	// public synchronized boolean outputXML(Map<Object, AccessConfig>
	// registeredAccessConfigs, String fileName) {
	// return writeXML(createXMLText(registeredAccessConfigs), fileName);
	//
	// }

	// public Document createXMLText(Map<Object, AccessConfig>
	// registeredAccessConfigs) {
	// final Document document = DocumentHelper.createDocument();
	// final Element root = document.addElement(CONFIGS);
	// for (final Entry<Object, AccessConfig> entry :
	// registeredAccessConfigs.entrySet()) {
	// final AccessConfig accessConfig = entry.getValue();
	// final Element config = root.addElement(CONFIG);
	// final Element status = config.addElement(STATUS);
	// status.setText(accessConfig.getStatus().toString());
	// final Element name = config.addElement(NAME);
	// name.setText(accessConfig.getName());
	// final Element descEle = config.addElement(DESCRIPTION);
	// descEle.setText(accessConfig.getDescription());
	// final Element driverEle = config.addElement(DRIVER);
	// driverEle.setText(accessConfig.getDriver().getName());
	// final Element serverEle = config.addElement(SERVER);
	// serverEle.setText(accessConfig.getServer());
	// if (!Strings.isNullOrEmpty(accessConfig.getJks())) {
	// final Element jksEle = config.addElement(JKS);
	// jksEle.setText(accessConfig.getJks());
	// }
	//
	// final Element userEle = config.addElement(USERNAME);
	// userEle.setText(accessConfig.getUsername());
	// final Element passEle = config.addElement(PASSWORD);
	// passEle.setText(accessConfig.getPassowrd());
	// final Element domainEle = config.addElement(DOMAIN);
	// domainEle.setText(accessConfig.getDomain());
	// final Element dateTime = config.addElement(MODIFIED_DATE);
	// dateTime.setText(accessConfig.getModifiedDate());
	//
	// final Element shortCore = config.addElement(SHORT_CORE);
	// shortCore.setText(String.valueOf(accessConfig.getShortPoolConfig().getCoreSize()));
	//
	// final Element shortMax = config.addElement(SHORT_MAX);
	// shortMax.setText(String.valueOf(accessConfig.getShortPoolConfig().getMaxSize()));
	//
	// final Element shortCapacity = config.addElement(SHORT_CAPACITY);
	// shortCapacity.setText(String.valueOf(accessConfig.getShortPoolConfig().getQueueCapacity()));
	//
	// final Element midCore = config.addElement(MEDIUM_CORE);
	// midCore.setText(String.valueOf(accessConfig.getMediumPoolConfig().getCoreSize()));
	//
	// final Element midMax = config.addElement(MEDIUM_MAX);
	// midMax.setText(String.valueOf(accessConfig.getMediumPoolConfig().getMaxSize()));
	//
	// final Element midCapacity = config.addElement(MEDIUM_CAPACITY);
	// midCapacity.setText(String.valueOf(accessConfig.getMediumPoolConfig().getQueueCapacity()));
	//
	// final Element longCore = config.addElement(LONG_CORE);
	// longCore.setText(String.valueOf(accessConfig.getLongPoolConfig().getCoreSize()));
	//
	// final Element longMax = config.addElement(LONG_MAX);
	// longMax.setText(String.valueOf(accessConfig.getLongPoolConfig().getMaxSize()));
	//
	// final Element longCapacity = config.addElement(LONG_CAPACITY);
	// longCapacity.setText(String.valueOf(accessConfig.getLongPoolConfig().getQueueCapacity()));
	//
	// final Element delay = config.addElement(DELAY);
	// delay.setText(String.valueOf(accessConfig.getDelay()));
	//
	// final Element timeout = config.addElement(TIMEOUT);
	// timeout.setText(String.valueOf(accessConfig.getTimeout()));
	//
	// }
	//
	// return document;
	// }

	// public boolean writeXML(Document document, String fileName) {
	// try {
	// final XMLWriter output = new XMLWriter(new FileWriter(new
	// File(fileName)));
	// output.write(document);
	// output.close();
	// logger.info("writeXML: filename = {}", fileName);
	//
	// } catch (final IOException e) {
	// logger.error("Error while writing to xml", e);
	// return false;
	// }
	// return true;
	// }

	public static Document parse(File file) throws DocumentException, UnsupportedEncodingException, FileNotFoundException {
		final SAXReader reader = new SAXReader();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		final Document document = reader.read(br);

		return document;
	}

	// public static List<AccessConfig> readAccessConfigs(File file, DriverHome
	// driverHome) {
	// List<String> drivers = new ArrayList<String>();
	// try {
	// drivers.addAll(driverHome.findAll().keySet());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// Document document;
	//
	// try {
	// logger.debug("Parse AccessConfig from file: {}", file.getAbsolutePath());
	// document = parse(file);
	// } catch (final Exception e1) {
	// logger.error("Error while reading access configs", e1);
	// return null;
	// }
	//
	// final Element root = document.getRootElement();
	// @SuppressWarnings("unchecked")
	// final List<Element> configs = root.elements(CONFIG);
	// logger.debug("Found {} config tags in file", configs.size());
	// final List<AccessConfig> accessConfigs = new ArrayList<AccessConfig>();
	// for (final Element config : configs) {
	// try {
	//
	// final Class<? extends ComputeDriver> cls =
	// driverHome.getByName(config.element(DRIVER).getText());
	//
	// final ComputeDriver obj =
	// DriverBuilder.buildDriver(cls, config.element(SERVER).getText(),
	// config.element(USERNAME).getText(),
	// config.element(PASSWORD).getText(), config.element(DOMAIN).getText());
	//
	// // if (obj.needTrustStoreFile()) {
	// // obj.configTrustStore(config.element(JKS).getText());
	// // }
	//
	// int shortCoreValue = PoolConfig.DEFAULT_SHORT_MIN;
	// int midCoreValue = PoolConfig.DEFAULT_MEDIUM_MIN;
	// int longCoreValue = PoolConfig.DEFAULT_LONG_MIN;
	// int shortMaxValue = PoolConfig.DEFAULT_SHORT_MAX;
	// int midMaxValue = PoolConfig.DEFAULT_MEDIUM_MAX;
	// int longMaxValue = PoolConfig.DEFAULT_LONG_MAX;
	// int shortCapacityValue = PoolConfig.DEFAULT_SHORT_QUEUE;
	// int midCapacityValue = PoolConfig.DEFAULT_MEDIUM_QUEUE;
	// int longCapacityValue = PoolConfig.DEFAULT_LONG_QUEUE;
	// int delayValue = CachedDriver.DEFAULT_CYCLE_TIME;
	// int timeoutValue = CachedDriver.DEFAULT_TIMEOUT;
	//
	// try {
	// shortCoreValue = Integer.parseInt(config.element(SHORT_CORE).getText());
	// } catch (final Exception e) {
	//
	// shortCoreValue = PoolConfig.DEFAULT_SHORT_MIN;
	// }
	//
	// try {
	// midCoreValue = Integer.parseInt(config.element(MEDIUM_CORE).getText());
	// } catch (final Exception e) {
	//
	// midCoreValue = PoolConfig.DEFAULT_MEDIUM_MIN;
	// }
	//
	// try {
	// longCoreValue = Integer.parseInt(config.element(LONG_CORE).getText());
	// } catch (final Exception e) {
	//
	// longCoreValue = PoolConfig.DEFAULT_LONG_MIN;
	// }
	//
	// try {
	// shortMaxValue = Integer.parseInt(config.element(SHORT_MAX).getText());
	// } catch (final Exception e) {
	//
	// shortMaxValue = PoolConfig.DEFAULT_SHORT_MAX;
	// }
	//
	// try {
	// midMaxValue = Integer.parseInt(config.element(MEDIUM_MAX).getText());
	// } catch (final Exception e) {
	//
	// midMaxValue = PoolConfig.DEFAULT_MEDIUM_MAX;
	// }
	//
	// try {
	// longMaxValue = Integer.parseInt(config.element(LONG_MAX).getText());
	// } catch (final Exception e) {
	//
	// longMaxValue = PoolConfig.DEFAULT_LONG_MAX;
	// }
	//
	// try {
	// shortCapacityValue =
	// Integer.parseInt(config.element(SHORT_CAPACITY).getText());
	// } catch (final Exception e) {
	//
	// shortCapacityValue = PoolConfig.DEFAULT_SHORT_QUEUE;
	// }
	//
	// try {
	// midCapacityValue =
	// Integer.parseInt(config.element(MEDIUM_CAPACITY).getText());
	// } catch (final Exception e) {
	//
	// midCapacityValue = PoolConfig.DEFAULT_MEDIUM_QUEUE;
	// }
	// try {
	// longCapacityValue =
	// Integer.parseInt(config.element(LONG_CAPACITY).getText());
	// } catch (final Exception e) {
	//
	// longCapacityValue = PoolConfig.DEFAULT_LONG_QUEUE;
	// }
	//
	// try {
	// delayValue = Integer.parseInt(config.element(DELAY).getText());
	// } catch (final Exception e) {
	// delayValue = CachedDriver.DEFAULT_CYCLE_TIME;
	// }
	//
	// try {
	// timeoutValue = Integer.parseInt(config.element(TIMEOUT).getText());
	// } catch (final Exception e) {
	// timeoutValue = CachedDriver.DEFAULT_TIMEOUT;
	// }
	//
	// PoolConfig shortPoolConfig = new PoolConfig(shortCoreValue,
	// shortMaxValue, shortCapacityValue);
	// PoolConfig mediumPoolConfig = new PoolConfig(midCoreValue, midMaxValue,
	// midCapacityValue);
	// PoolConfig longPoolConfig = new PoolConfig(longCoreValue, longMaxValue,
	// longCapacityValue);
	//
	// final AccessConfig accessConfig =
	// new AccessConfig(config.element(STATUS) != null ?
	// Boolean.valueOf(config.element(STATUS).getText())
	// : true, config.element(NAME).getText(),
	// config.element(DESCRIPTION).getText(),
	// new DriverProxy(obj), config.element(SERVER).getText(),
	// config.element(USERNAME).getText(),
	// config.element(PASSWORD).getText(), config.element(DOMAIN).getText(),
	// config.element(
	// MODIFIED_DATE).getText(), shortPoolConfig, mediumPoolConfig,
	// longPoolConfig,
	// delayValue, timeoutValue);
	// accessConfigs.add(accessConfig);
	// } catch (final Exception e) {
	// logger.error("Error while reading access configs", e);
	// }
	// }
	//
	// logger.info("readXML: filename = {}", file.getAbsolutePath());
	//
	// return accessConfigs;
	// }

	@SuppressWarnings("unchecked")
	public static <T> T convertValue(File file, Class<T> toValueType) throws Exception {
		JAXBContext context;
		BufferedReader reader = null;
		// FileReader reader = null;
		T t;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			context = JAXBContext.newInstance(toValueType);
			Unmarshaller um = context.createUnmarshaller();
			t = (T) um.unmarshal(reader);
			logger.info("parse xml success");
			return t;
		} catch (Exception e) {
			logger.warn("parse xml failed: " + file.getAbsolutePath(), e);
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error("unexpected exception when trying close reader", e);
				}
			}
		}

	}

}
