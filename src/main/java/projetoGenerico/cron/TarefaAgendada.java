package projetoGenerico.cron;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TarefaAgendada {

	private static final Logger LOG = Logger.getLogger(TarefaAgendada.class);

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job exportCustomerJob;

	@Scheduled(cron = "10 0/1 * 1/1 * *")
	public void iniciarJob() {
		LOG.info("[ job Gerar Base Regutória ENABLED");
		try {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime inicio = LocalDateTime.now();
			LOG.info("-----------------------------------------------------------------------------------------------");
			LOG.info("[ Inicio: - Data = " + inicio.format(pattern) + " ]");

			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
			jobParametersBuilder.addLong("time", System.currentTimeMillis());
			JobExecution jobExecution = jobLauncher.run(exportCustomerJob, jobParametersBuilder.toJobParameters());
			reportResults(jobExecution);

			LocalDateTime fim = LocalDateTime.now();
			LOG.info("[ Fim: - Data = " + fim.format(pattern) + " - Tempo = " + (fim.getSecond() - inicio.getSecond())
					+ "(segundos)");
			LOG.info("-----------------------------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void reportResults(JobExecution jobExecution) {
		Collection<StepExecution> stepExecutions = jobExecution.getStepExecutions();
		LOG.info(String.format("%s foi finalizado com o status de %s (%s).", jobExecution.getJobInstance().getJobName(),
				jobExecution.getExitStatus().getExitDescription(), jobExecution.getExitStatus().getExitCode()));
		LOG.info("* Steps executados:");
		for (StepExecution stepExecution : stepExecutions) {
			LOG.info(String.format("\t%s : %s", stepExecution.getStepName(), stepExecution.getExitStatus()));
			LOG.info(stepExecution.getSummary());
		}
	}
}
