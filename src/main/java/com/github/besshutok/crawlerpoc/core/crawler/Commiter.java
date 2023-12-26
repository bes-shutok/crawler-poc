package com.github.besshutok.crawlerpoc.core.crawler;

import com.norconex.committer.core3.*;
import com.norconex.committer.core3.fs.AbstractFSCommitter;
import com.norconex.committer.core3.fs.impl.XMLFileCommitter;
import com.norconex.commons.lang.xml.EnhancedXMLStreamWriter;
import com.norconex.commons.lang.xml.XML;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Writer;

/**
 * Committer implementation
 */
@Slf4j
public class Commiter extends XMLFileCommitter {



//	@Override
//	protected String getFileExtension() {
//		log.info( "getFileExtension" );
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	protected Object createDocWriter( Writer writer ) throws IOException {
//		log.info( "createDocWriter" );
//		throw new UnsupportedOperationException();
//	}
//
	@Override
	protected void writeUpsert( EnhancedXMLStreamWriter xml, UpsertRequest upsertRequest ) throws IOException {
		log.info( "writeUpsert" );
		super.writeUpsert( xml, upsertRequest );
	}

	@Override
	protected void writeDelete( EnhancedXMLStreamWriter xml, DeleteRequest deleteRequest ) throws IOException {
		log.info( "writeDelete" );
		super.writeDelete( xml, deleteRequest );
	}

//	@Override
//	protected void closeDocWriter( Object docWriter ) throws IOException {
//		log.info( "closeDocWriter" );
//		throw new UnsupportedOperationException();
//	}

	//	@Override
//	protected void doInit() throws CommitterException {
//		log.info( "init" );
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	protected void doUpsert( UpsertRequest upsertRequest ) throws CommitterException {
//		log.info( "upsert" );
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	protected void doDelete( DeleteRequest deleteRequest ) throws CommitterException {
//		log.info( "delete" );
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	protected void doClose() throws CommitterException {
//		log.info( "close" );
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	protected void doClean() throws CommitterException {
//		log.info( "clean" );
//		throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public void loadCommitterFromXML( XML xml ) {
//		log.info( "loadCommitterFromXML" );
//		return;
//		//throw new UnsupportedOperationException();
//	}
//
//	@Override
//	public void saveCommitterToXML( XML xml ) {
//		log.info( "saveCommitterToXML" );
//		throw new UnsupportedOperationException();
//	}

}
